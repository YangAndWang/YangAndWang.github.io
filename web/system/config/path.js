const fs = require('fs')
const path = require('path')

const reactPath = path.resolve(__dirname, '../src/react')
const components = {}

const reactComponent = fs.readdirSync(path.resolve(__dirname, '../src/react/components/')).forEach(fileName => {
    components[fileName.toLowerCase()] = path.resolve(__dirname, '../src/react/components/', fileName)
})
const reactIndex = path.resolve(__dirname, '../src/react')
module.exports = {
    react: {
        components,
        reactIndex
    },
    dist: path.resolve(__dirname, '../dist'),
    build: path.resolve(__dirname, '../build')
}