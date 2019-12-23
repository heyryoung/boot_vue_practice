<template>
<div>
  <div id="host-header">
        <h1 align = "center">업체 회원 가입</h1>
      </div>
        <fieldset>
        <legend>아이디 입력 </legend>
        <span><input type="text" id="hostId" name="hostId" maxlength="20" v-model="person.cid"></span>
        </fieldset>
        <fieldset>
        <legend>패스워드 입력 </legend>
        <input type="pw" id="userPw" name="hostPw" maxlength="20" autocomplete="off" v-model="person.pwd">
        <div><label for="hostCheck">패스워드확인</label></div>
        <div><input type="pw" id="hostPwCheck" name="hostPwCheck" maxlength="20" autocomplete="off"></div>
        </fieldset>
        <fieldset>
        <legend>이름 입력 </legend>
        <div><label for="hostName">이름</label></div>
        <div><input type="text" id="hostName" name="hostName" maxlength="20" v-model="person.name"></div>
        </fieldset>
        <fieldset>
        <legend>생일 입력  </legend>
        <div><label for="nickName">닉네임</label></div>
        <div><input type="text" id="nickName" name="nickName" maxlength="20" v-model="person.birthday"></div>
        </fieldset>
        <fieldset>
        <legend>이메일 입력 </legend>
        <div><input type="text" id="email01" name="email01" size="20" maxlength="20"
             value="" autocomplete="off"><span>@</span>
            <input id="email02" name="email02" list="domains" placeholder="도메인입력/선택">
            <select id="domains" style="height: 21.5px;vertical-align: middle;">
                <option value="직접입력">직접입력</option>
                <option value="naver.com">naver.com</option>
                <option value="daum.net">daum.net</option>
                <option value="gmail.com">gmail.com</option>
                <option value="yahoo.co.kr">yahoo.co.kr</option>
            </select>
        </div>
            <div><label>이메일수신</label></div>
            <div>
                <input type="radio" name="emailYn" value="Y" checked>수신
                <input type="radio" name="emailYn" value="N">미수신
            </div>
        </fieldset>
        <fieldset>
        <legend>연락처 입력 </legend>
			<div>
				<select id="mPhone1" name="mPhone1">
					<option value="010" selected>010</option>
					<option value="011">011</option>
					<option value="016">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>-
				<input type="number" value="" size="4" maxlength="4" autocomplete="off">-
				<input type="number" value="" size="4" maxlength="4" autocomplete="off">
			</div>
			<div><label>SMS수신</label></div>
			<div>
				<input type="radio" name="smsYn" value="Y" checked>수신
				<input type="radio" name="smsYn" value="N">미수신
			</div>
        </fieldset>
        <fieldset>
        <legend>업체주소 입력 </legend>
            <input type="text" name="pwd" size="20" placeholder="시/도 입력 " autocomplete="address-level1" >
            <input type="text" name="pwd" size="20" placeholder="시/군/구 입력" autocomplete="address-level2">
        <input type="text" name="pwd" size="20" placeholder="상세주소 입력" autocomplete="address-line1" style="float: none;width: 78%;">
                <button >등록</button><br/><br/>
        </fieldset>
        <fieldset>
        <legend>사업자등록번호 입력 </legend>
                <input type="text" name="pwd" size="20" placeholder="사업자등록번호 입력">
                <button >등록</button><br/><br/>
        </fieldset>
        <fieldset>
        <legend>업체종류 선택 </legend>
            <div class="formfield">
                <input type="radio" name="hosttype" value="숙박" alt="업체종류" >숙박
                <input type="radio" name="hosttype" value="음식점" alt="업체종류" >음식점
                <input type="radio" name="hosttype" value="교통" alt="업체종류" >교통
                <input type="radio" name="hosttype" value="기타" alt="업체종류">기타
                <input type="text" placeholder="직접입력" >
                    <button >등록</button><br/><br/>
            </div>
        </fieldset>
        <fieldset>
        <legend>업체소개 등록 </legend>
            <textarea name="info" id="hostinfo" placeholder="업체 소개를 입력해 주세요" cols="30" rows="10" style="width: 98%;"></textarea><br/>
            <button style="float: right;">저장</button><br/><br/>
        </fieldset>
        <div class="btnfield" style="text-align: center">
            <input type="button" value="회원가입" @click="join">
        </div>
</div>
</template>
<script>
 import axios from "axios" 
export default {
  data(){
    return{
    context : 'http://localhost:8080',        
    person : {
        cid: '' ,
        pwd : '',
        name: '',
        birthday:''
    }
    }
  },
methods : {
        join() {
            let url = `${this.context}/join`
            let data = this.person
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, data, headers)
            .then(res=>{
              if(res.data.result ==="SUCCESS"){
                alert(`가입 성공 `);
                this.$router.push({path:  '/login'})   
              }else{
                alert(`로그인 실패 `);                
                this.$router.push({path:  '/join'})                        
              }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
        }
    }
}


</script>
<style scoped>
.container {
  min-height: 530px;
  height: 100vh;
  width: 100vw;
  background-image: linear-gradient(253deg, #40B09B 0, #3FB493 100%);
  color: white;
}
.form-wrapper {
  min-width: 50%;
}
.layout.wrap {
  height: 100vh;
}
.active {
  background: #fff;
  color: #40AE9F;
}
#sign-in,
.switch #sign-up {
  width: 60%;
}
#sign-up,
.switch #sign-in {
  min-width: 25%;
  width: auto;
}
.form-wrapper .v-input__control > .v-input__slot {
  background: rgba(244, 248, 247, 1);
}
.form-wrapper .v-text-field.v-text-field--enclosed .v-text-field__details {
  margin-bottom: 0px;
  height: 0px;
}
#sign-in-text-wrapper {
  background-image: linear-gradient(253deg, #40B09B 0, #3FB493 100%);
  position: absolute;
  animation: 0.75s linear slide-back-left;
  left: 0;
  right: auto;
  height: 100vh;
  width: 33%;
}
#sign-up-form-wrapper {
  position: absolute;
  animation: 0.75s linear slide-back-right;
  right: 0;
  left: auto;
  height: 100vh;
  width: 67%;
}
#sign-in-text-wrapper.switch {
  background-image: linear-gradient(253deg, #40A9AA 0, #40ABA6 100%);
  right: 0;
  left: auto;
  animation: 0.75s linear slide-right;
  -webkit-animation-fill-mode: both;
}
#sign-up-form-wrapper.switch {
  left: 0;
  animation: 0.75s linear slide-left;
}
@keyframes slide-left {
  0% {
    left: 33%;
    opacity: 0;
  }
  50% {
    left: 25%;
    opacity: 0;
  }
  100% {
    left: 0;
    opacity: 1;
  }
}
@keyframes slide-right {
  0% {
    right: 100%;
    width: 33%;
    z-index: 1;
  }
  20% {
    right: 75%;
    width: 60%;
    max-width: 60%;
    z-index: 1;
  }
  100% {
    right: 0;
    width: 33%;
    max-width: 35%;
    z-index: 1;
  }
}
@keyframes slide-back-left {
  0% {
    left: 67%;
    width: 33%;
    z-index: 1;
  }
  20% {
    left: 50%;
    width: 60%;
    max-width: 60%;
    z-index: 1;
  }
  100% {
    left: 0;
    width: 33%;
    z-index: 1;
  }
}
@keyframes slide-back-right {
  0% {
    left: 0;
    opacity: 0;
  }
  50% {
    left: 25%;
    opacity: 0;
  }
  100% {
    left: 33%;
    opacity: 1;
  }
}
.background-shapes-wrapper {
  position: absolute;
  width: 100vw;
  height: 100%;
  top: 0;
  overflow: hidden;
}
.background-shapes-container {
  width: 100%;
  height: 100%;
  position: relative;
}
.background-shape {
  position: absolute;
  background-color: rgba(255, 255, 255, 0.1);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  z-index: 10;
}
.square-one {
  width: 30px;
  height: 30px;
  top: 15%;
  left: 20%;
  -webkit-transform: rotate(-65deg);
  transform: rotate(-65deg);
}
.square-two {
  width: 25px;
  height: 25px;
  top: 55%;
  right: 1%;
  -webkit-transform: rotate(-65deg);
  transform: rotate(-65deg);
}
.square-three {
  width: 50px;
  height: 50px;
  top: 30%;
  left: 45%;
  -webkit-transform: rotate(-65deg);
  transform: rotate(-65deg);
}
.circle-one {
  width: 250px;
  height: 250px;
  border-radius: 100%;
  bottom: -125px;
  left: -125px;
}
.circle-two {
  width: 30px;
  height: 30px;
  bottom: 20%;
  right: 25%;
  border-radius: 100%;
}
.triangle-one {
  width: 0;
  height: 0;
  border-top: 69px solid transparent;
  border-bottom: 48px solid transparent;
  border-left: 90px solid rgba(255, 255, 255, 0.08);
  top: 45%;
  left: 30%;
  background-color: transparent;
  -webkit-transform: rotate(-100deg);
  transform: rotate(-100deg);
}
.triangle-two {
  width: 0;
  height: 0;
  border-top: 200px solid transparent;
  border-bottom: 130px solid transparent;
  border-left: 180px solid rgba(255, 255, 255, 0.1);
  top: -150px;
  right: -80px;
  background-color: transparent;
  -webkit-transform: rotate(-80deg);
  transform: rotate(-80deg);
}
.triangle-three {
  width: 0;
  height: 0;
  border-top: 68px solid transparent;
  border-bottom: 49px solid transparent;
  border-left: 90px solid rgba(255, 255, 255, 0.08);
  right: 10%;
  bottom: 1%;
  background-color: transparent;
  transform: rotate(-170deg);
}
.rectangle-one {
  width: 25px;
  height: 50px;
  top: 80%;
  left: 25%;
  -webkit-transform: rotate(-55deg);
  transform: rotate(-55deg);
}
.rectangle-two {
  width: 15px;
  height: 30px;
  top: 42%;
  right: 23%;
  -webkit-transform: rotate(-55deg);
  transform: rotate(-55deg);
}
</style>