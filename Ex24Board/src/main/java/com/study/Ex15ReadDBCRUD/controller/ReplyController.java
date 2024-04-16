package com.study.Ex15ReadDBCRUD.controller;

import com.study.Ex15ReadDBCRUD.domain.reply.Reply;
import com.study.Ex15ReadDBCRUD.dto.ReplySaveRequestDto;
import com.study.Ex15ReadDBCRUD.service.ReplyService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    final private ReplyService replyService;

    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto){
        System.out.println(dto.toString());
        Long newReplyIdx = replyService.save( dto );

        boolean isFound = replyService.existsById( newReplyIdx );
        if( isFound == true ){
            return "<script>alert('댓글쓰기 성공'); location.href='/';</script>";
        }else{
            return "<script>alert('댓글쓰기 실패'); history.back();</script>";
        }
    }

    @GetMapping("/deleteReplyAction")
    @ResponseBody
    public String deleteReplyAction(@RequestParam Long replyIdx){
        try{
            replyService.delete(replyIdx);
        } catch (Exception e){
            e.printStackTrace();
            return "<script>alert('댓글 삭제 실패'); history.back();</script>";
        }
        return "<script>alert('댓글 삭제 성공'); location.href='/board/listForm';</script>";
    }
}
