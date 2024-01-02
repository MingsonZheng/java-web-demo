<template>
  <div>
    <!-- <h1>{{message}}</h1> -->
    <element-view></element-view>
  </div>
  <!-- <div id="app">
    <nav>
      <router-link to="/">Vue Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view/>
  </div> -->
</template>

<script>
import ElementView from './views/element/ElementView.vue'
export default {
  components: { ElementView },
  data() {
    return {
      message: "Hello vue222"
    }
  },
  methods: {
    
  }
  // data: function(){
  //   return {
  //     message: "Hello vue"
  //   }
  }
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
} */
</style>
