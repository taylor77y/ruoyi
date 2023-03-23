<template>
  <div id="memberAmount">
    <el-row>
      <el-col :span="8" v-for="(item,index) in list" :key="index">
        <el-card class="box-card">
          {{item.currency}}
          <el-divider></el-divider>
          {{item.amount}}
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {
    getLiveAmountData
} from "@/api/report";
export default {
    name:'memberAmount',
    data(){
        return{
            list:[]
        }
    },
    created(){},
    mounted(){
        getLiveAmountData().then(res=>{
            this.list = res.data;
        })
    },
    methods:{

    }
}
</script>

<style lang="scss" scoped>
#memberAmount{
    box-sizing: border-box;
    padding: 10px;
}
</style>
