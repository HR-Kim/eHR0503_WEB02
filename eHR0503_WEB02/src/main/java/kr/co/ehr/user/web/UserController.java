package kr.co.ehr.user.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import com.google.gson.Gson;

import kr.co.ehr.cmn.Message;
import kr.co.ehr.user.service.User;
import kr.co.ehr.user.service.UserService;
import kr.co.ehr.user.service.UserVO;

@Controller
public class UserController {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	UserService userService;
	
	//View
	private final String VIEW_NM = "user/user_mng";
	//http://localhost:8080/ehr/user/do_user_view.do
	
	@RequestMapping(value="user/do_user_view.do",method = RequestMethod.GET)
	public String doUserView() {
		LOG.debug("=========================");
		LOG.debug("=@Controller=doUserView==");
		LOG.debug("=========================");
		return VIEW_NM;
	}
	//수정
	@RequestMapping(value="user/do_update.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody		
	public String do_update(User user) {
		LOG.debug("1=========================");
		LOG.debug("=@Controller=user=="+user);
		LOG.debug("1=========================");
		
		//validation
		int flag = userService.update(user);
		Message message=new Message();
		if(flag>0) {
			message.setMsgId(flag+"");
			message.setMsgMsg(user.getU_id()+"님 수정 되었습니다.");
		}else {
			message.setMsgId(flag+"");
			message.setMsgMsg(user.getU_id()+"님 수정 실패.");			
		}
	
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);
		LOG.debug("2=========================");
		LOG.debug("=@Controller=json=="+json);
		LOG.debug("2=========================");
		return json;		
	}
	
	//등록
	@RequestMapping(value="user/do_insert.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody	
	public String do_insert(User user) { 
		LOG.debug("1=========================");
		LOG.debug("=@Controller=user=="+user);
		LOG.debug("=@Controller=gethLevel=="+user.gethLevel());
		LOG.debug("1=========================");
		
		//validation
		int flag = userService.add(user);
		Message message=new Message();
		if(flag>0) {
			message.setMsgId(flag+"");
			message.setMsgMsg(user.getU_id()+"님 등록 되었습니다.");
		}else {
			message.setMsgId(flag+"");
			message.setMsgMsg(user.getU_id()+"님 등록 실패.");			
		}
	
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);
		LOG.debug("1=========================");
		LOG.debug("=@Controller=json=="+json);
		LOG.debug("1=========================");
		return json;
	}
	
	
	//삭제
	@RequestMapping(value="user/do_delete.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String do_delete(User user) {
		LOG.debug("=========================");
		LOG.debug("=@Controller=user=="+user);
		LOG.debug("=========================");
		
		//flag>0성공,실패
		int flag = userService.deleteUser(user);
		Message message=new Message();
		
		if(flag>0) {
			message.setMsgId(flag+"");
			message.setMsgMsg("삭제 되었습니다.");
		}else {
			message.setMsgId(flag+"");
			message.setMsgMsg("삭제 실패.");			
		}
		
		//JSON변환
		Gson gson=new Gson();
		String json = gson.toJson(message);
		LOG.debug("=========================");
		LOG.debug("=@Controller삭제 gson=user=="+json);
		LOG.debug("=========================");		
		return json;
	}

	
	//단건조회
	@RequestMapping(value="user/get_select_one.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String get_selectOne(User user,Model model) {
		LOG.debug("=========================");
		LOG.debug("=@Controller=user=="+user);
		LOG.debug("=========================");
		if(null == user.getU_id() || "".equals(user.getU_id())) {
			throw new IllegalArgumentException("ID를 입력 하세요.");
		}
		User outVO = userService.get(user.getU_id());
		
		
		
		
		//model.addAttribute("vo", outVO);
		Gson gson=new Gson();
		String json = gson.toJson(outVO);
		LOG.debug("=========================");
		LOG.debug("=@Controller gson=user=="+json);
		LOG.debug("=@Controller outVO=="+outVO.toString());
		LOG.debug("=========================");		
		
		return json;
	}
	
	
	
	
}







