<template>
<div id="app">
	<layout>
		<template #header="header">
				<component :is="whichCompo ? 'LogOutHeader' : 'LogInHeader' "></component>
		</template>
		<template #sidebar="sidebar">
			<ul>
				<li  v-for="sidebar of sidebars" :key="sidebar.menu">
					<router-link :to ="sidebar.link">{{sidebar.menu}}</router-link>
				</li>
			</ul>
		</template>
		<template #section="section">
					<router-view></router-view>
		</template>
		<template #footer="footer">
			<div>{{footer.title}}</div>
		</template>
	</layout>	
</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import LogInHeader from "@/components/cmm/LogInHeader.vue"
import LogOutHeader from "@/components/cmm/LogOutHeader.vue" 
import {store} from "@/store"
export default{
	components : {Layout ,LogInHeader,LogOutHeader},	
	data(){
		return {
			sidebars: [
				{menu : "Home", link: "/"},
				{menu : "Write", link: "/write"},
				{menu : "List", link: "/list"},
				{menu : "Update", link: "/update"},
				{menu : "Remove", link: "/remove"},
				{menu : "Search", link: "/search"}
			],
			person : store.state.person
}
	},
	methods: {

		},
  computed: {
    whichCompo () {
		return store.state.loginstate
    }
  }
}
</script>
<style scoped>

ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>
