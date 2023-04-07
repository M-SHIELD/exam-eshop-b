module.exports = {
    presets: [
        '@vue/cli-plugin-babel/preset',
        ["@babel/preset-env", {
            "useBuiltIns": "entry"
        }]
    ],
    "plugins": [
        ['import', {
            libraryName: 'vant',
            libraryDirectory: 'es',
            style: true
        }, 'vant']
    ]
}
