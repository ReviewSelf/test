import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);



const store =new Vuex.Store({
    state:{
        isLogin:false,
        User:{
            userId:'',
            category:'',
            users:{
                nick:'',
                solved:'',
                submit:'',
                email:'',
                school:'',
            }
        },

    },
    mutations:{
        login(state){
            state.isLogin=true;
        },
        quit(state){
            state.isLogin=false;
        },
        saveLoginUser(state,status){
            state.User.userId=status.userId,
            state.User.category=status.category,
            state.User.users=status.users
        }
    },
    getters:{
        getUser(state){
            return state.User
        }
    }
})

export default store;