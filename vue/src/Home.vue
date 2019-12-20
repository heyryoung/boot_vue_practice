<template>
<div id="app">
	<layout>
		<template #header="header">
			<div>
				<div  v-for="header of headers" :key="header.menu">
					<router-link :to ="header.link">{{header.menu}}</router-link>
				</div>				
			</div>
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
export default{
	components : {Layout},
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
			headers: [
				{menu : "Join", link: "/Join"},
				{menu : "Login", link: "/login"}
			],
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
