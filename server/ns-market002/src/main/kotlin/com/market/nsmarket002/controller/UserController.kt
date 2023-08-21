package com.market.nsmarket002.controller

import com.market.nsmarket002.model.*
import com.market.nsmarket002.service.UserService
import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import java.io.File

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Service API", description = "User Service Api입니다.")
class UserController (
    private val userService: UserService,
){
//    @Parameter(name = "SignUpRequest", description = "2번 반복할 문자열")
    @PostMapping("/signup")
    @Operation(summary = "SignUp(회원가입) 기능입니다.", description = "회원가입 데이터를 가져와서 저장, 잘못된 데이터이면 오류를 반환합니다.")
    suspend fun signup(@RequestBody request: SignUpRequest){
        userService.signUp(request)
    }
    @Operation(summary = "SignIn(로그인) 기능입니다.", description = "로그인 데이터를 가져옵니다 제대로된 정보이면 토큰을 발행합니다.. 중복되거나 다른아이디일경우 오류를 반환합니다..")
    @PostMapping("/signin")
    suspend fun signIn(@RequestBody singInRequest: SignInRequest): SignInResponse {
        return userService.signIn(singInRequest)
    }

    @Operation(summary = "logOut(로그아웃) 기능입니다.", description = "로그아웃합니다.")
    @Parameter(name = "Authorization", description = "Token 값")
    @DeleteMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun logout(@AuthToken token: String){
        userService.logout(token)
    }

    @GetMapping("/me")
    suspend fun get(
        @AuthToken token: String
    ) : MeResponse {
        return MeResponse(userService.getByToken(token))
    }

    //    @Operation(summary = "SignUp(회원가입) 기능입니다.", description = "회원가입 데이터를 가져와서 저장, 잘못된 데이터이면 오류를 반환합니다.")
    @GetMapping("/{userId}/username")
    suspend fun getUserName(@PathVariable userId: Long): Map<String, String>{
        return mapOf("reporter" to userService.get(userId).username)
    }


    @Operation(summary = "유저 정보를 수정하는 기능입니다.", description = "회원 데이터를 수정합니다 이미지 추가 기능 있습니다")
    @PostMapping("/{id}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    suspend fun edit(
        @PathVariable id:Long,
        @ModelAttribute request: UserEditRequest,
        @AuthToken token: String,
        @RequestPart("profileUrl") filePart: FilePart,
    ){
        val orgFIlename = filePart.filename()
        var filename: String? = null
        if(orgFIlename.isNotEmpty()){
            val ext = orgFIlename.substring(orgFIlename.lastIndexOf(".") +1) //확장자 구하는것
            filename = "${id}.${ext}"


            //resources/images/1.jpg 예시
            val file = File(ClassPathResource("/images").file , filename)
            filePart.transferTo(file).awaitSingleOrNull()

        }
        userService.edit(token, request.username, filename)
    }

    @GetMapping("/test1")
    suspend fun test1() : String{
        return "it's ok"
    }

}