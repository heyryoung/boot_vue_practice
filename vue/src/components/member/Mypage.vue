<template>
  <div class="back">
     <div align = "center"><h1>{{person.name}}님의 Mypage</h1> </div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>개인 정보</h3></legend>
               <div  style="float: left; width: 20%;"> 생일 </div> <div  style="float: none; width: 70%;"> {{person.birthday}}</div>
                <div  style="float: left; width: 20%;"> 성별 </div><div  style="float: none; width: 70%;"> {{person.gender}}</div>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>학생부 관리 </h3></legend>
               <div  style="float: left; width: 20%;"> 생일 </div><div  style="float: center; width: 70%;">{{person.birthday}} </div>
                <div  style="float: left; width: 20%;"> 성별 </div><div  style="float: center; width: 70%;">{{person.gender}}</div> 
                <div  style="float: left; width: 20%;"> 반 </div><div  style="float: center; width: 70%;">{{person.hak}} </div>
                <div  style="float: left; width: 20%;"> 반 </div><div  style="float: center; width: 70%;">{{person.ban}} </div>
                <div  style="float: left; width: 20%;"> 성적  </div><div  style="float: center; width: 70%;">{{person.score}}</div> 
                <br/><br/>
                <router-link to ="/mypageUpdate">수정</router-link>                
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
    name: store.state.name,
    person : store.state.person
    }
  },
  methods: {
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
