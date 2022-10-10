<template>
	<div id="root">
	<a v-bind:href="href">测试</a>
    <input v-model="placeholder"/>
	</div>
</template>

<script>


	export default {
		name:'App',
		data() {
			return {
        href:"www.baidu.com",
        placeholder:"deprecatedDestroyed "

			}
		},
		methods: {

		}
	}
</script>

<style></style>
