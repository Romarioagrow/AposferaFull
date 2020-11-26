<template>
  <v-col cols="4">
    <v-hover v-slot:default="{ hover }">
      <v-card :elevation="hover ? 12 : 2">
        <v-card-actions>
          <v-btn block text height="200">
            Add New Moon
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-hover>
  </v-col>
</template>

<script>
export default {
  name: "CreateAstroObjectButton"
}
</script>

<style scoped>

</style>