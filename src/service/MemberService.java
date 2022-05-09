package service;

import entity.*;
import model.*;
import model.*;
import repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemberService {

    public static List<User> getAllMembers(){
        List<MemberEntity> memberEntities = MemberRepository.findAll();
        List<User> members = new ArrayList<>();

        for(MemberEntity memberEntity:memberEntities){
            List<ReadingListEntity> rl = ReadingListRepository.findByMember(memberEntity.getId());
            Member member = new Member(memberEntity.getEmail(), memberEntity.getNickname(),memberEntity.getBirthday(), memberEntity.getPassword());

            for(ReadingListEntity readingListEntity:rl){
                ReadingState status = ReadingState.valueOf(readingListEntity.getStatus());
                ReadingScore score = ReadingScore.valueOf(readingListEntity.getScore());
                if(Objects.equals(readingListEntity.getType(), "novel")){
                    Novel novel = BookService.getNovelsById(readingListEntity.getBook_id());
                    member.addBook(novel, status, readingListEntity.getAmount_read(), score, readingListEntity.getStart_date(), readingListEntity.getEnd_date());
                }
                if(Objects.equals(readingListEntity.getType(), "comics")){
                    Comics comics = BookService.getComicsById(readingListEntity.getBook_id());
                    member.addBook(comics, status, readingListEntity.getAmount_read(), score, readingListEntity.getStart_date(), readingListEntity.getEnd_date());
                }
                if(Objects.equals(readingListEntity.getType(), "illustration")){
                    Illustrations illust = BookService.getIllustrationById(readingListEntity.getBook_id());
                    member.addBook(illust, status, readingListEntity.getAmount_read(), score, readingListEntity.getStart_date(), readingListEntity.getEnd_date());
                }
                if(Objects.equals(readingListEntity.getType(), "poetry")){
                    Poetry poetry = BookService.getPoetryById(readingListEntity.getBook_id());
                    member.addBook(poetry, status, readingListEntity.getAmount_read(), score, readingListEntity.getStart_date(), readingListEntity.getEnd_date());
                }
            }
            members.add(member);
            System.out.println("MEMBRU");
            System.out.println(member);
            System.out.println(member.getList());
        }

    return members;
    }

}
