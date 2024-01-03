<template>
    <div>
        <el-container style="height: 700px; border: 1px solid #eee">
            <el-header style="font-size:40px; background-color: rgb(238, 241, 246)">智能学习辅助系统</el-header>
            <el-container>
                <el-aside width="230px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                            <el-menu-item index="1-1">
                                <router-link to="/dept">部门管理</router-link>
                            </el-menu-item>
                            <el-menu-item index="1-2">
                                <router-link to="/emp">员工管理</router-link>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-main>
                    
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            tableData: [
                {
                    "id": 1,
                    "name": "谢逊",
                    "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/web/1.jpg",
                    "gender": 1,
                    "job": "班主任",
                    "entrydate": "2008-05-09",
                    "updatetime": "2022-10-01 12:00:00"
                },
                {
                    "id": 2,
                    "name": "黛绮丝",
                    "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/web/4.jpg",
                    "gender": 2,
                    "job": "讲师",
                    "entrydate": "2018-05-09",
                    "updatetime": "2022-10-01 12:00:00"
                }
            ],
            searchForm: {
                name: "",
                gender: "",
                entrydate: []
            }
        }
    },
    methods: {
        onSubmit:function(){
            alert("查询数据");
        },
        handleSizeChange:function(val){
        alert("每页记录数变化" + val);
        },
        handleCurrentChange:function(val){
            alert("页码发生变化" + val);
        },
        mounted() {
            // 发送异步请求，获取数据
            axios.get("http://yapi.smart-xwork.cn/mock/169327/emp/list").then((result) => {
                this.tableData = result.data.data;
            });
        }
    }
}
</script>

<style>

</style>