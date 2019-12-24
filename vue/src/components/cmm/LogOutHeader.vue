<template>
<div id="pagewrap">
			<div>
				<div  v-for="header of headers" :key="header.menu">
					<router-link :to ="header.link">{{header.menu}}</router-link>
				</div>				
                    <router-link to ="/login" @click="logout">LogOUT</router-link >                    
			</div>     
</div>
</template>
<script>
import {store} from "../../store"
export default { 
	data(){
		return {
			headers: [
				{menu : "Join", link: "/Join"},
				{menu : "Mypage", link: "/mypage"}
			]               
		}
     },
  methods: {
    logout (){
              alert('로그아웃 ')
                store.state.loginedCid = ''
                store.state.loginedPwd = ''
                store.state.person = {}
                store.state.loginstate = false                
                this.$router.push({path:  '/login'})                  
    }  
}
}
</script>
<style scoped>
</style>
