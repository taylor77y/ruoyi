<template>
  <div class="container">
    <el-empty description="没有配置客服链接！" v-if="!contactLink"></el-empty>
    <div class="contact" v-else>
      <iframe class="iframe" :src="contactLink" frameborder="0" align="middle" width="100%" height="1000px">
      </iframe>
    </div>
  </div>
</template>

<script>
import { listCustomerService } from "@/api/system/customerService";
export default {
  data() {
    return {
      total: 0,
      loading: true,
      customerServiceList: [],
      contactLink: ''
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      listCustomerService(this.queryParams).then(response => {
        this.customerServiceList = response.rows;
        if (response.rows) {
          for(let item of response.rows){
            if(item.type == 1 && item.status == 1){
              this.contactLink = item.contactLink
              break;
            }
          }
        }
        this.total = response.total;
        this.loading = false;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
.container {
  // display: flex;
  width: 100%;
  height: calc(100vh - 100px);

  .contact {
    position: relative;
    width: 100%;
    height: 100%;

    .iframe{
      width: 100%;
      height: 100%;
    }
  }
}
</style>
