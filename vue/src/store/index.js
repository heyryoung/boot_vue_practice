import Vue from "vue"
import Vuex from 'vuex'

Vue.use(Vuex)
export const store= new Vuex.Store({
state: {
	id: '',
	offerId: '',
	loginedCid: '',
	loginedPwd:'',
	person: {} ,
	loginstate : false
}
})