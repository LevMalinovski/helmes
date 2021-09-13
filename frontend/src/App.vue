<template>
  <div id="app">
    <el-container>
      <el-main>
      <router-view/>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import {fetchToken} from "@/api/init";

export default {
  name: "App",
  created() {
    let token = localStorage.getItem('token');
    if (!token) {
      fetchToken().then(token => {
        localStorage.setItem('token', token.data);
      });
    }
  }
};
</script>