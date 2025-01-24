/////게시글 작성 관련
const pathArr = [];
//api
tinymce.init({
    license_key: "gpl",
    selector: "#newsContent",
    resize: "both",
    height: 600,
    plugins: "image media emoticons",
    menubar: false,
    statusbar: false,
    promotion: false,
    toolbar:
        "undo redo | fontfamily fontsize bold italic" +
        "forecolor backcolor | alignleft " +
        "aligncenter alignright alignjustify " +
        "| image  media emoticons",
    font_family_formats:
        "Noto Sans KR=Noto Sans KR;" +
        "Noto Serif KR=Noto Serif KR;" +
        "Gowun Batang=Gowun Batang;" +
        "Gowun Dodum=Gowun Dodum;" +
        "Orbit=Orbit;" +
        "Nanum Gothic=Nanum Gothic;" +
        "Nanum Myeongjo=Nanum Myeongjo;" +
        "Nanum Brush Script=Nanum Brush Script;",
    font_size_formats: "12pt 14pt 16pt 18pt 20pt 24pt 28pt 36pt 48pt",
    content_style:
        "@import url('https://fonts.googleapis.com/css2?family" +
        "=Gowun+Batang&family=Gowun+Dodum&family=Nanum+Brush" +
        "+Script&family=Nanum+Gothic&family=Nanum+Myeongjo&f" +
        "amily=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR:" +
        "wght@200..900&family=Orbit&display=swap');" +
        "body {font-family: 'Noto Sans Kr';",
    file_picker_types: "image",
    file_picker_callback: function (callback, value, meta) {
        const input = document.createElement("input");
        input.setAttribute("type", "file");
        input.setAttribute("accept", "image/*");

        input.onchange = async function () {
            const file = this.files[0];
            const imgName =
                file.name.substring(file.name.lastIndexOf("/") + 1);
            const path = await processImage(file, imgName, 1);
            pathArr.push(path);
            callback(path, { title: file.name });
        }
        input.click();
    }
});

//썸네일
const thumbBtn = document.getElementById("thumbBtn");
thumbBtn.addEventListener("click", function () {
    const input = document.createElement("input");
    const thumbImg = document.getElementById("thumbImg");
    input.setAttribute("type", "file");
    input.setAttribute("accept", "image/*");

    input.onchange = async function () {
        const file = input.files[0];
        const imgName =
            file.name.substring(file.name.lastIndexOf("/") + 1);
        console.log(imgName);
        const path = await processImage(file, imgName, 0);
        thumbImg.src = path;
        pathArr.push(path);
    }
    input.click();
});

//이미지 임시 저장
const processImage = async function (file, imgName, imgType) {
    const formData = new FormData();
    formData.append("image", file);
    formData.append("imgName", imgName);
    formData.append("imgType", imgType);

    try {
        const response = await fetch("/image/temp", {
            method: "POST",
            body: formData
        });
        if (!response.ok) {
            throw new Error("Upload failed : !response.ok");
        }
        return await response.text();
    } catch (error) {
        console.error(error);
    }
};
//////////

/////버튼 관련
const submitBtn = document.getElementById("submitBtn");
const backBtn = document.getElementById("backBtn");

//제출 버튼
submitBtn.addEventListener("click", async function (e) {
    //도네이션 insert 
    const form = document.querySelector("form");
    let bid;
    try {
        const response = await fetch("/news/insert", {
            method: "POST",
            body: new FormData(form)
        });
        if (!response.ok) {
            throw new Error("failed : insert news")
        }
        bid = await response.json();
        console.log(bid);
    } catch (error) {
        console.error
    }

    //1)이미지들 temp->upload로 이동
    //2)content 넣기
    const content = tinymce.get("newsContent").getContent();
    const boardType = document.getElementById("boardType").value;

    try {
        const formData = new FormData();
        pathArr.forEach(fileName => {
            formData.append("uploadFileNames", fileName);
        });
        formData.append("bid", bid);
        formData.append("content", content);
        formData.append("boardType", boardType);
        const response = await fetch("/image/upload", {
            method: "POST",
            body: formData
        });
        if (!response.ok) {
            throw new Error("failed : save upload");
        }
    } catch (error) {
        console.error(error);
    }
});

//뒤로가기 버튼 
backBtn.addEventListener("click", async function () {
    try {
        const formData = new FormData();
        pathArr.forEach(fileName => {
            formData.append("uploadFileNames", fileName);
        });
        const response = await fetch("/image/delete", {
            method: "DELETE",
            body: formData
        });
        if (!response.ok) {
            throw new Error("delete temp files failed");
        }
        const isDeleted = await response.json();
        if (disDeleted) {
            window.history.back();
        }
    } catch (error) {
        console.error(error);
    }
});
//////////

