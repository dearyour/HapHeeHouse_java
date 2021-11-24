package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.LoginDto;
import com.ssafy.happyhouse.model.dto.UserBeforeChangePasswordDto;
import com.ssafy.happyhouse.model.dto.UserChangePasswordDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.service.JwtServiceImpl;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private UserService userService;

	
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserid(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	@GetMapping("/logout")
	public ResponseEntity<Integer> logout(HttpSession session) {
		session.removeAttribute("userInfo");
		log.info("logout() - 로그아웃 처리 ");
		return ResponseEntity.ok(1);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto memberDto = userService.myPage(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/join")
	public ResponseEntity<Integer> join(@RequestBody UserDto vo) {
		log.info("join() : " + vo);
		return ResponseEntity.ok(userService.join(vo));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody UserDto userDto) throws Exception {
//		String userId = (String)session.getAttribute("userInfo"); HttpSession session
//		log.info("update() - 회원정보 수정 " + userid);
		int status = userService.memberUpdate(userDto);
		if (status == 0)
			return ResponseEntity.ok(0);
		else {
			return ResponseEntity.ok(1);
		}
	}

	
//	@DeleteMapping("/delete")
//	public ResponseEntity<Integer> delete( String userid, String userpwd, HttpSession session) throws Exception {
//		log.info("delete() - 회원정보 삭제 " +  ", " + userpwd);
////		String userid = (String)session.getAttribute("userInfo");
//		 
//		// "USER"로 바인딩된 객체를 돌려준다. ("USER"로 바인딩된 객체가 없다면 null)
//		UserDto userVO = (UserDto) session.getAttribute("USER");
//		if(userVO != null) {
//		    // 사용자 정보를 가져올 수 있다.
//		    userid=userVO.getUserid(); // hong
//		    userpwd=userVO.getUserpwd(); // 홍길동
//		}
//		int status = userService.memberWithdraw(userid, userpwd);
//		if (status != 0 ) {
//			// db 삭제
////			userService.memberWithdraw(userid, userpwd);
//			// session 값 삭제
//			session.removeAttribute("userInfo");
//			// 로그인 페이지로 돌아가도록
//			return ResponseEntity.ok(1); 
//		} else {
//			return ResponseEntity.ok(-1);
//		}
//	}
	
	//String userid, String userpwd
	
//	@DeleteMapping("/delete")
//	public ResponseEntity<Integer> delete(@RequestBody String userpwd, HttpSession session) throws Exception {
//		log.info("delete() - 회원정보 삭제 " +  ", " + userpwd );
//		String userid = (String)session.getAttribute("userInfo");
////		HashMap userInfo = (HashMap) session.getAttribute("userInfo");
////		String userid = (String) userInfo.get("userid");
//		int status = userService.checkPassword(new LoginDto(userid, userpwd));
//		if (status != 0 ) {
//			// db 삭제
//			userService.memberWithdraw(userid, userpwd);
//			// session 값 삭제
//			session.removeAttribute("userInfo");
//			// 로그인 페이지로 돌아가도록
//			return ResponseEntity.ok(1); 
//		} else {
//			return ResponseEntity.ok(-1);
//		}
//	} 
	
	//리퀘스트바디
	@DeleteMapping("/delete")
	public ResponseEntity<Integer> delete(@RequestBody String userpwd, HttpSession session) throws Exception {
		log.info("delete() - 회원정보 삭제 " +  ", " + userpwd);
		String userid = (String)session.getAttribute("userInfo");
		int status = userService.checkPassword(new LoginDto(userid, userpwd));
		if (status != 0 ) {
			// db 삭제
			userService.memberWithdraw(userid, userpwd);
			// session 값 삭제
			session.removeAttribute("userInfo");
			// 로그인 페이지로 돌아가도록
			return ResponseEntity.ok(1); 
		} else {
			return ResponseEntity.ok(-1);
		}
	} 
	
//	//원본
//	@DeleteMapping("/delete")
//	public ResponseEntity<Integer> delete(String confirmText, String userpwd, HttpSession session) throws Exception {
//		log.info("delete() - 회원정보 삭제 " + confirmText + ", " + userpwd);
//		String userid = (String)session.getAttribute("userInfo");
//		int status = userService.checkPassword(new LoginDto(userid, userpwd));
//		if (status != 0 && "모든 정보를 삭제하고 탈퇴하겠습니다.".equals(confirmText)) {
//			// db 삭제
//			userService.memberWithdraw(userid, userpwd);
//			// session 값 삭제
//			session.removeAttribute("userInfo");
//			// 로그인 페이지로 돌아가도록
//			return ResponseEntity.ok(1); 
//		} else {
//			return ResponseEntity.ok(-1);
//		}
//	} 
	


	@GetMapping("/check-info")
	public ResponseEntity<Integer> checkInfoBeforeChangePassword(UserBeforeChangePasswordDto userChangePasswordDto) {
		log.info("비밀번호 변경 전 정보 확인: " + userChangePasswordDto);
		int status = userService.checkInfo(userChangePasswordDto);
		if (status == 1) {
			return ResponseEntity.ok(1);
		}
		return ResponseEntity.ok(0);
	}
	// 비밀번호 찾기 완료
	@PostMapping("/change-password")
	public ResponseEntity<Integer> findPw(UserChangePasswordDto userChangePasswordDto) {
		log.info("비밀번호 변경: " + userChangePasswordDto);
		int status;
		if (userChangePasswordDto.getUserpwd().equals(userChangePasswordDto.getPasswordCheck())) {
			status = userService.changePassword(new LoginDto(userChangePasswordDto.getUserid(), userChangePasswordDto.getUserpwd()));
		} else {
			status = 0;
		}
		return ResponseEntity.ok(status);
	}
	@GetMapping("/find-userId")
	public ResponseEntity<String> findId(String name, String email) {
		UserDto dto = new UserDto();
		dto.setName(name);
		dto.setEmail(email);
		return ResponseEntity.ok(userService.findUserId(dto));
	}
	
	// 아이디 중복 검사
	@GetMapping("/check-userId")
	public ResponseEntity<Integer> check_id(String userId) {
		return ResponseEntity.ok(userService.checkUserId(userId));
	}

}
