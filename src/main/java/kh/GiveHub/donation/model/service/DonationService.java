package kh.GiveHub.donation.model.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kh.GiveHub.donation.model.mapper.DonationMapper;
import kh.GiveHub.donation.model.vo.Donation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DonationService {
    private final DonationMapper mapper;

    public int deleteDona(String no) {
        return mapper.deleteDona(no);
    }

    public ArrayList<Donation> selectDonaList(int i) {
        return mapper.selectDonaList(i);
    }

    public ArrayList<Donation> selectCategory(String category) {
        return mapper.selectCategory(category);
    }

    public ArrayList<Donation> orderBy(String type) {
        return mapper.selectOrderBy(type);
    }

    public ArrayList<Donation> search(Donation d) { return mapper.search(d);}



    public Donation selectDonation(int doNo, Integer id) {
        Donation d = mapper.selectDonation(doNo);
        if (d != null && id != null && d.getMemNo()==id) {
            int result = mapper.updateCount(doNo);
            if (result > 0) {
                d.setDoViews(d.getDoViews() + 1);

            }
        }
        return d;
    }

	public void setContent(int bid, String content) {
		Pattern pattern = 
				Pattern.compile("<img[^>]+?src=\"([^\"]+)\"[^>]*?>");
		Matcher matcher = pattern.matcher(content);
		StringBuilder newContent = new StringBuilder(content);
		while(matcher.find()) {
			String oldPath = matcher.group(1);
			String newPath = oldPath.replace("/temp/", "/upload/");
			int index = newContent.indexOf(oldPath);
			newContent.replace(index, index+oldPath.length(), newPath);
		}
		mapper.setContent(bid, content);
	}

	public int insertDonation(Donation d) {
		return mapper.insertDonation(d);
	}
}
