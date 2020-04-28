<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Weapons />
  </div>
</template>

<script>
import Weapons from './components/Weapons.vue'

export default {
  name: 'App',
  components: {
    Weapons
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
