module.exports = {
  outputDir: './dist',
  indexPath: './index.html',
  devServer: {
    proxy: 'http://localhost:8080/vuetest',
  },
  chainWebpack: (config) => {
    const svgRule = config.module.rule('svg');
    svgRule.uses.clear();
    svgRule.use('vue-svg-loader').loader('vue-svg-loader');
  },
};
