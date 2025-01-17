package com.busanit501.samplejsp501.menu.service;

import com.busanit501.samplejsp501.menu.dao.MenuMemberDAO;
import com.busanit501.samplejsp501.menu.domain.MenuMemberVO;
import com.busanit501.samplejsp501.menu.dto.MenuMemberDTO;
import com.busanit501.samplejsp501.todo.domain.MemberVO;
import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MenuMemberService {
  INSTANCE;

  private MenuMemberDAO menuMemberDAO;
  private ModelMapper modelMapper;

  MenuMemberService() {
    menuMemberDAO = new MenuMemberDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  // 하나 조회
  public MenuMemberDTO getOneMember(String mid, String mpw) throws Exception {
    MenuMemberVO sample = menuMemberDAO.getWithPasswordMember(mid, mpw);
//    log.info("TodoService , 확인1, sample : " + sample);
    MenuMemberDTO menuMemberDTO = modelMapper.map(sample, MenuMemberDTO.class);
    return menuMemberDTO;
  }

  public void insertMember(MenuMemberDTO menuMemberDTO) throws Exception {
    MenuMemberVO menuMemberVO = modelMapper.map(menuMemberDTO, MenuMemberVO.class);
    menuMemberDAO.insertMember(menuMemberVO);
  }

  public void updateUUID(String mid, String uuid) throws Exception {
    menuMemberDAO.updateUUID(mid, uuid);
  }

  public MenuMemberDTO selectUUID(String uuid) throws Exception {
    MenuMemberVO menuMemberVO = menuMemberDAO.selectUUID(uuid);
    MenuMemberDTO menuMemberDTO = modelMapper.map(menuMemberVO, MenuMemberDTO.class);
    return menuMemberDTO;

  }

}
