<template>
    <div class="login-form">
        <h2 class="text-center">Login</h2>
        <div class="form-group has-error">
        <input type="text" class="form-control" name="cid" placeholder="Username" required="required" v-model="user.cid" >
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="pwd" placeholder="Password" required="required" v-model="user.pwd" >
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block"  @click.prevent="login">Sign in</button>
        </div>
        <p><a href="#">Lost your Password?</a></p>
    <p class="text-center small">Don't have an account? <router-link to ="/join">Sign up here!</router-link></p>
</div>
</template>
<script>
 import axios from "axios" 
 import {store} from "../../store"
 
export default {
  data(){
    return {
      context : 'http://localhost:8080/',
      result: '' ,
      user:{cid : '' , pwd: ''},
      logincId: '',
      loginpw:'',
      person: {}
    }
  },
methods : {
        login() {
            let url = `${this.context}/login`
            let data = {
              cid : this.user.cid,
              pwd : this.user.pwd
            }
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url,data, headers)
            .then(res=>{
              if(res.data.result ==="SUCCESS"){
                this.person = res.data.data  
                store.state.loginedCid = this.person.cid
                store.state.loginedPwd = this.person.pwd
                store.state.person = this.person
                store.state.loginstate = true
                alert(`로그인 성공  ${this.person.name}`);
                this.$router.push({path:  '/mypage'})                 
              }else{
                alert(`로그인 실패 `);                
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
body {
  color: #fff;
  background: #3598DC;
}
.form-control {
  min-height: 41px;
  background: #F2F2F2;
  box-shadow: none !important;
  border: transparent;
}
.form-control:focus {
  background: #E2E2E2;
}
.form-control, .btn {
  border-radius: 2px;
}
.login-form {
  width: 350px;
  margin: 30px auto;
  text-align: center;
}
.login-form h2 {
  margin: 10px 0 25px;
}
.login-form form {
  color: #7A7A7A;
  border-radius: 3px;
  margin-bottom: 15px;
  background: #fff;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  padding: 30px;
}
.login-form .btn {
  font-size: 16px;
  font-weight: bold;
  background: #3598DC;
  border: none;
  outline: none !important;
}
.login-form .btn:hover, .login-form .btn:focus {
  background: #2389CD;
}
.login-form a {
  color: #fff;
  text-decoration: underline;
}
.login-form a:hover {
  text-decoration: none;
}
.login-form form a {
  color: #7A7A7A;
  text-decoration: none;
}
.login-form form a:hover {
  text-decoration: underline;
}
</style>