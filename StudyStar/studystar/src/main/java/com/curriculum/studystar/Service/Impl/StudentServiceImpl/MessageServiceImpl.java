package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.Message;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.GetMessageListResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetMessageResponse;
import com.curriculum.studystar.Mapper.MessageMapper;
import com.curriculum.studystar.Mapper.UserMapper;
import com.curriculum.studystar.Service.StudentService.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public GetMessageResponse GetMessage(String userId) {
        GetMessageResponse resp = new GetMessageResponse();
        GetMessageListResp list = new GetMessageListResp();

        ArrayList<Message> messages = messageMapper.SelectMessageByReceiverId(userId);
        for(Message message : messages){
            String senderName = userMapper.SelectUserByUserId(message.getSenderId()).getUserName();
            list.addData(message.getTitle(), message.getContent(), message.getIsRead(), message.getSendTime(), senderName);
        }
        resp.setResponse(list);
        
        return resp;
    }
    
}
