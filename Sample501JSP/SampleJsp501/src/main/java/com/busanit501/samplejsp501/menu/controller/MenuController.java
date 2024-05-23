package com.busanit501.samplejsp501.menu.controller;

import com.busanit501.samplejsp501.menu.dto.MenuDTO2;
import com.busanit501.samplejsp501.menu.dto.MenuMemberDTO;
import com.busanit501.samplejsp501.menu.service.MenuService;
import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "menulist",urlPatterns = "/menu/list")
public class MenuController extends HttpServlet {

  //주입 , 서비스 인스턴스 , 포함.
  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // DB 에서 , 전체 목록을 가져오기.

    // 설정한 세션의 정보 가져오기.
    // 값 문자열 타입.
//    HttpSession session = req.getSession();
//    String loginInfoSession = (String) session.getAttribute("loginInfo");
//    log.info("Login info 세션의 정보 get하기.: " + loginInfoSession);
    // 방법2 , 값 인스턴스
    HttpSession session = req.getSession();
    MenuMemberDTO menuMemberDTO = (MenuMemberDTO) session.getAttribute("loginInfo");
    log.info("Login info 세션의 정보 get하기.: " + menuMemberDTO);

    try {
      //todoService.listAll(); -> 디비에서, 전체 목록 가져오기.
      List<MenuDTO2> sampleList = menuService.listAll();
//      log.info("TodoListController , 확인2, sampleList : " + sampleList);

      // 컨트롤러에서 (서버)-> 화면(jsp)에 -> 데이터 전달
      req.setAttribute("list",sampleList);
      req.setAttribute("menuMemberDTO",menuMemberDTO);
      req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}







