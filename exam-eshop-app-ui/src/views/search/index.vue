<template>
  <div>
    <van-search
        v-model="value"
        shape="round"
        background="#FF0000"
        placeholder="请输入搜索关键词"
    />
    <div class="history">
      <div>
        <span class="historytext">最近搜索</span>
      </div>
      <span
          class="hisitem"
          v-for="(item, index) in historylist"
          :key="index"
      >{{ item }}</span>
    </div>
    <div class="history">
      <div>
        <span class="historytext">热门搜索</span>
      </div>
      <span
          class="hisitem"
          v-for="(item, index) in historylist"
          :key="index"
      >{{ item }}</span>
    </div>
<!--    <van-grid :column-num="2">-->
<!--      <van-grid-item v-for="value in 4" :key="value" icon="photo-o" text="华为￥1000" style="height: 4rem; width: 0.7rem"/>-->
<!--    </van-grid>-->
    <van-empty image="error" description="没有搜到该商品，换个关键词试试吧！" />

    <FooterMenu :active="0"></FooterMenu>
  </div>
</template>


<script>
import FooterMenu from "@/components/footerMenu";

export default {
  name: "search",
  components: {FooterMenu},
  data() {
    return {
      value: '',
      historylist:['Nike', 'newbalance', 'adidas']

    };
  },
}
</script>

<style lang="less" scoped>
.history{
  height: 3rem;
}
.historytext{
  font-size: 0.4rem;
}
.hisitem{
  font-size: 0.4rem;
  background: #f3f3f3;
  color: #cccccc;
  margin: 0.3rem;
  padding: 0.1rem;
}
</style>
