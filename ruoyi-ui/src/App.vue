<template>
  <div id="app">
    <router-view />
     <!-- 预警声音 音频元素   -->
        <audio class="audio"
               src="@/utils/y913.mp3"
               controls
               id="warningAudio"
               hidden="true">
        </audio>
    <!-- 平台客服   -->
        <audio class="audio"
               src="@/utils/kf.mp3"
               controls
               id="warningAudio2"
               hidden="true">
        </audio>
        <!-- 法币客服   -->
        <audio class="audio"
               src="@/utils/fabi.mp3"
               controls
               id="warningAudio3"
               hidden="true">
        </audio>
  </div>
</template>

<script>
export default  {
  name:  'App',
    metaInfo() {
        return {
            title: this.$store.state.settings.dynamicTitle && this.$store.state.settings.title,
            titleTemplate: title => {
                return title ? `${title} - ${process.env.VUE_APP_TITLE}` : process.env.VUE_APP_TITLE
            }
        }
    }
}
</script>
