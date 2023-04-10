<template>
  <div>
    <!--    搜索框-->
    <van-search
        class="top-search"
        input-align="center"
        v-model="searchValue"
        background="#fff"
        placeholder="请输入搜索关键词"
    />


    <!--左右分类布局-->
    <van-tree-select class="typeRoom" height="55vw" :items="items" :main-active-index.sync="typeActive">
      <template #content>
        <div :key="inx" v-for="(n,inx) in items">
          <div v-if="typeActive==inx" class="typeshow">
            <img class="type-bg" :src="n.imgUrl" alt="">
            <div :key="index" v-for="(list,index) in n.children" class="typeList">
              <div class="typeName">{{ list.cname }}</div>
              <van-grid :border="false" :column-num="3">
                <van-grid-item class="type-list" v-for="(l2,i2) in list.children" :key="i2"
                               :icon="l2.imgUrl"
                               :text="l2.cname">
                </van-grid-item>
              </van-grid>
            </div>
          </div>
        </div>

      </template>
    </van-tree-select>

    <!--    底部菜单-->
    <FooterMenu :active="1"></FooterMenu>
  </div>

</template>

<script>
import FooterMenu from "@/components/footerMenu";
import {categoryList} from "@/api/category";

export default {
  name: "Type",
  components: {FooterMenu},
  data() {
    return {
      active: 1,
      searchValue: "",
      typeActive: 0,
      items: [],
    }


  },
  methods: {
    initTypeData() {
      categoryList().then(e => {
        this.items = e.data
        this.items.forEach(e => {
          e.text = e.cname
        })
      })
    }
  },
  mounted() {
    this.initTypeData()
  }
}
</script>

<style scoped>
.top-search {
  /*width: 6rem;*/
  height: 1.5rem;
}

.van-search__content {
  border-radius: .2rem;
}

.typeRoom {
  height: 90vh !important;
}

/deep/ .van-tree-select__nav {
  border-right: 1px solid #ccc;
  width: 3rem;
}

/*/deep/.van-tree-select__nav-item{*/
/*  vertical-align: middle;*/
/*  width: 3rem;*/
/*}*/
.typeName {
  padding: .1rem 0 .1rem 0;
  margin: 0 .3rem;
  line-height: .7rem;
  border-bottom: .001rem solid #ccc;
}

.type-bg {
  width: 90%;
  height: 100%;
  /*margin: .2rem;*/
  padding: .2rem;
}
</style>
