<template>
  <div class="back">
     <div align = "center"><h1><input type="text" v-model="person.name"/>{{person.name}}님의 Mypage</h1> <input type="button" value="로그아웃" @click="logout"/></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>개인 정보</h3></legend>
               <div  style="float: left; width: 20%;"> 생일 </div> <div  style="float: none; width: 70%;"> {{person.birthday}}</div>
                <div  style="float: left; width: 20%;"> 성별 </div><div  style="float: none; width: 70%;"> {{person.gender}}</div>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>학생부 관리 </h3></legend>
               <div  style="float: left; width: 20%;"> 생일 </div><input type="text"  size="20" placeholder="변경할 생일 입력" v-model="person.birthday"  style="float: center; width: 70%;">
                <div  style="float: left; width: 20%;"> 성별 </div><input type="text" size="20" placeholder="변경할 성별  입력" v-model="person.gender" style="float: center;width: 70%;">
                <div  style="float: left; width: 20%;"> 학년 </div><input type="text" size="20" placeholder="변경할 학년  입력" v-model="person.hak" style="float: center;width: 70%;"> 
                <div  style="float: left; width: 20%;"> 반 </div><input type="text" size="20" placeholder="변경할 반 입력" v-model="person.ban"  style="float: center;width: 70%;"> 
                <div  style="float: left; width: 20%;"> 성적  </div><input type="text" size="20" placeholder="변경할 성적 입력" v-model="person.score"   style="float: center;width: 70%;"> 
                <br/><br/>                
                <button style="height: 20%; width: 70%; float: none;" @click.prevent="modify">수정</button>
           </fieldset>
        </div>
        <div class="pull-right size" >
            <fieldset style="height: 49%;border: 2px solid black;">
                <legend><h3>정보보기</h3></legend>
                <a href="#" ><h3>예약리스트 보기</h3></a>
                <a href="#" ><h3 align = "center">내업체 보기</h3></a>
                <a href="#" ><h3 align = "center">업체 등록 하기</h3></a>
            </fieldset>
            <fieldset style="margin-top: 1%; height: 47.5%; border: 2px solid black;">
              <legend><h3>등록업체 삭제</h3></legend>
              <select name="pat" id="pattype" style="height: 21.5px; vertical-align:middle;">
               <option value="LargeDog">업체1</option>
               <option value="LargeDog">업체2</option>
               <option value="SmallDog">업체3</option>
               <input type="text" placeholder="직접입력" style="float: none; width: 70%;">
              </select>
                <button style="width: 20%; float: right;">등록</button><br/><br/>
              <a href="#" @click.prevent="Withdrawal"><h2 align="center">회원탈퇴</h2></a>
            </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
 import axios from "axios" 
import {store} from "../../store"
export default {
  data(){
    return {
    context : 'http://localhost:8080/',
    name: store.state.name,
    person : store.state.person
    }
  },
  methods: {
    logout (){
              alert('로그아웃 ')
                store.state.loginedCid = ''
                store.state.loginedPwd = ''
                store.state.name = ''
                store.state.birthday = ''
                store.state.id = ''
                this.$router.push({path:  '/login'})                  
    },
    modify (){
            let url = `${this.context}/modify`
            let data = this.person
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }      
            axios
            .post(url, data, headers)
            .then(res=>{
              this.person = res.data.data
              if(res.data.result ==="SUCCESS"){
                alert(`수정  성공 `);
                this.$router.push({path:  '/mypage'})
              }else{
                alert(`수정 실패 `);                
                this.$router.push({path:  '/join'})                        
              }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })             
    },
    Withdrawal(){
           alert('withdraw from the union')
            axios
            .delete(`${this.context}/withdrawal/${store.state.loginedCid}`)
            .then(()=>{
                alert(`success in withdrawal`)
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
    }
  }
}


</script>
 <style scoped>
    .back {width: 700px; margin: 0 ;}
    .sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>
