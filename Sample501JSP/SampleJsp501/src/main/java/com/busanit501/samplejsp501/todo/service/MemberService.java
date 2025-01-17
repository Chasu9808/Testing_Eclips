package com.busanit501.samplejsp501.todo.service;

import com.busanit501.samplejsp501.todo.dao.MemberDAO;
import com.busanit501.samplejsp501.todo.domain.MemberVO;
import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
  INSTANCE;

  private MemberDAO memberDAO;
  private ModelMapper modelMapper;

  MemberService() {
    memberDAO = new MemberDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  // 하나 조회
  public MemberDTO getOneMember(String mid, String mpw) throws Exception {
    MemberVO sample = memberDAO.getWithPasswordMember(mid, mpw);
//    log.info("TodoService , 확인1, sample : " + sample);
    MemberDTO memberDTO = modelMapper.map(sample, MemberDTO.class);
    return memberDTO;
  }

  public void updateUUID(String mid, String uuid) throws Exception {
    memberDAO.updateUUID(mid, uuid);
  }

  public MemberDTO selectUUID(String uuid) throws Exception {
    MemberVO memberVO = memberDAO.selectUUID(uuid);
    MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
    return memberDTO;

  }

}
