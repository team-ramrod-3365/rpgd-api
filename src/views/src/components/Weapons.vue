<template>
  <div class="container">
    <h3>Weapons:</h3>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Type</th>
          <th scope="col">Description</th>
          <th scope="col">Attack Power</th>
          <th scope="col">Attack Type</th>
          <th scope="col">Special Ability</th>
          <th scope="col">Weight</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="weapon in weapons" v-bind:key="weapon.id"> 
          <th scope="row">{{weapon.id}}</th>
          <td>{{weapon.name}}</td>
          <td>{{weapon.type}}</td>
          <td>{{weapon.description}}</td>
          <td>{{weapon.attackPower}}</td>
          <td>{{weapon.attackType}}</td>
          <td>{{weapon.specialAbility}}</td>
          <td>{{weapon.weight}}</td>
        </tr>
      </tbody>
    </table> 
  </div> 
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'Weapons',
    data() {
      return {
        weapons: null,
      };
    },
    created: function() {
      axios.get('http://localhost:8090/weapons')
           .then(res => {
             this.weapons = res.data;
           })
    },
  }
</script>

<style>
  h3 {
    margin-bottom: 5%;
  }
</style>