<template>
    <div id="memberNew">
        <el-row>
            <el-date-picker
                v-model="info"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
                </el-date-picker>
            <el-button type="primary" @click="chaxun">查询</el-button>
        </el-row>
        <div class="link"></div>
        <el-row>
            <div class="box">
                <span :class="current === 1 ? 'cor' : 'cor2'" @click="setIndex(1)">日</span>
                <span :class="current === 2 ? 'cor' : 'cor2'" @click="setIndex(2)">月</span>
                <span :class="current === 3 ? 'cor' : 'cor2'" @click="setIndex(3)">年</span>
            </div>
        </el-row>
        <div id="echart-line" class="line"></div>
    </div>
</template>

<script>
import {
    getAddUserData
} from "@/api/report";
import echarts from  "echarts";
export default {
    data(){
        return{
            info:null,
            current:1,
            form:{
                type:1,
                startTime:null,
                endTime:null
            }
        }
    },
    created(){},
    mounted(){
        this.getLine();
    },
    methods:{
        setIndex(e){
            this.current = e;
            this.form.type = e
            this.getLine();
        },
        initBody(data){
            let getchart = echarts.init(document.getElementById('echart-line'));
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: data.names,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '新增人数',
                        type: 'bar',
                        barWidth: '60%',
                        data: data.nums
                    }
                ]
            };
            getchart.setOption(option);
            //随着屏幕大小调节图表
            window.addEventListener("resize", () => {
                getchart.resize();
            });
        },
        getLine(){
            getAddUserData(this.form).then(res=>{
                this.initBody(res.data);
            })
        },
        chaxun(){
            if(this.info != null){
                this.form.startTime = this.info[0]
                this.form.endTime = this.info[1]
                this.form.type = 4
                this.getLine();
            }
            console.log(this.info)
        }
    }
}
</script>

<style scoped lang="scss">
#memberNew{
 box-sizing: border-box;
 padding: 30px 0 0 0;
}
.line{
    width: 100%;
    height: 420px;
}
.cor{
    box-sizing: border-box;
    padding: 5px 15px;
    line-height: 6px;
    font-size: 8px;
    background: #F2F6FC;
}
.cor2{
    box-sizing: border-box;
    padding: 5px 15px;
    line-height: 6px;
    font-size: 8px;
    border: 1px solid;
}
.link{
    height: 20px;
}
.el-row{
    margin-left: 100px;
}
.el-button{
    margin-left: 15px;
}
</style>
