<template>
  <v-container>
    <v-row>
      <v-col>
        <v-card>
          <v-card-actions>

            <v-row justify="start" class="ml-5">
              <v-btn color="primary" dark @click.stop="dialog = true">
                New Astro
              </v-btn>

              <v-btn color="red" :outlined="deleteMode" @click.stop="deleteMode = !deleteMode" class="ml-3">
                Delete Mode
              </v-btn>

              <v-dialog
                  v-model="dialog"
                  max-width="1000"
              >
                <v-card>
                  <v-card-title class="headline">
                    Add new AstroObjects Menu
                  </v-card-title>
                  <v-card-actions>
                    <v-row>

                      <!--
                      !!! РАЗБИТЬ НА КОМПОНЕНТЫ
                      -->

                      <!--create-astro-object-button-->


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

                      <v-col cols="4">
                        <v-hover v-slot:default="{ hover }">
                          <v-card :elevation="hover ? 12 : 2">
                            <v-card-actions>
                              <v-btn block text height="200">
                                Add New Planet
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </v-col>

                      <v-col cols="4">
                        <v-hover v-slot:default="{ hover }">
                          <v-card :elevation="hover ? 12 : 2">
                            <v-card-actions>
                              <v-btn block text height="200">
                                Add New Star
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </v-col>

                      <v-col cols="4">
                        <v-hover v-slot:default="{ hover }">
                          <v-card :elevation="hover ? 12 : 2">
                            <v-card-actions>
                              <v-btn block text height="200">
                                Add New System
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </v-col>

                      <v-col cols="4">
                        <v-hover v-slot:default="{ hover }">
                          <v-card :elevation="hover ? 12 : 2">
                            <v-card-actions>
                              <v-btn block text height="200" @click="addNewGalaxy()">
                                Add New Galaxy
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </v-col>
                      <v-col cols="4">
                        <v-hover v-slot:default="{ hover }">
                          <v-card :elevation="hover ? 12 : 2">
                            <v-card-actions>
                              <v-btn block text height="200">
                                New Astro Object
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-hover>
                      </v-col>
                    </v-row>
                  </v-card-actions>
                  <v-divider></v-divider>
                  <v-card-actions>
                    <v-row>
                      <v-col>
                        <v-card outlined>
                          <v-card-title>
                            Add star
                          </v-card-title>
                          <v-card-actions>
                            <v-row>
                              <v-col>
                                <v-text-field label="Star name" v-model="newStarName"></v-text-field>
                              </v-col>
                              <v-col>
                                <v-text-field label="Star class" v-model="newStarClass"></v-text-field>
                              </v-col>
                              <v-col>
                                <v-text-field label="Star temperature" v-model="newStarTemp"></v-text-field>
                              </v-col>
                            </v-row>
                          </v-card-actions>
                          <v-card-actions>
                            <v-btn color="primary" @click="addNewStar()" :disabled="comp_starButton">Add New Star</v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-col>
                    </v-row>
                  </v-card-actions>
                  <!--STAR SYSTEMS MENU-->
                  <v-card-actions>
                    <v-row>
                      <v-col>
                        <v-card outlined>
                          <v-card-title>
                            Add planet to star
                          </v-card-title>
                          <v-card-actions>
                            <v-row>
                              <v-col>
                                <v-select
                                    :items="starsAvailable"
                                    v-model="starName"
                                    label="Select Star"
                                    @change="selectStar()"
                                    solo
                                ></v-select>
                              </v-col>
                              <v-col>
                                <v-text-field label="Planet name" v-model="newPlanetName"></v-text-field>
                              </v-col>
                              <v-col>
                                <v-text-field label="Planet type" v-model="newPlanetType"></v-text-field>
                              </v-col>
                            </v-row>
                          </v-card-actions>
                          <v-card-actions>
                            <v-btn color="success" @click="addNewPlanet()" :disabled="comp_planetButton">Add New Planet</v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-col>
                    </v-row>
                  </v-card-actions>
                  <!---->
                  <!--MOON TO PLANET-->
                  <v-card-actions>
                    <v-row>
                      <v-col>
                        <v-card outlined>
                          <v-card-title>
                            Add moon to planet
                          </v-card-title>
                          <v-card-actions>
                            <v-row>
                              <v-col>
                                <v-select
                                    :items="starsAvailable"
                                    v-model="starName"
                                    label="Select star"
                                    @change="selectStar()"
                                    solo
                                ></v-select>
                              </v-col>
                              <v-col>
                                <v-select
                                    :items="planetsAvailable"
                                    v-model="planetName"
                                    label="Select planet"
                                    solo
                                ></v-select>
                              </v-col>
                              <v-col>
                                <v-text-field label="Moon name" v-model="newPlanetName"></v-text-field>
                              </v-col>
                              <v-col>
                                <v-text-field label="Planet type" v-model="newPlanetType"></v-text-field>
                              </v-col>
                            </v-row>
                          </v-card-actions>
                          <v-card-actions>
                            <v-btn color="success" @click="addNewMoon()" :disabled="comp_planetButton">Add New Moon</v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-col>
                    </v-row>
                  </v-card-actions>
                  <!---->
                </v-card>
              </v-dialog>
            </v-row>

          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>


</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      dialog: false,
      deleteMode: false,

      newStarName:'',
      newStarClass:'',
      newStarTemp:'',
      stars: [],

      newPlanetName:'',
      newPlanetType:'',
      starName: '',
      planetName: '',
    }
  },
  methods: {
    addNewGalaxy() {

    },

    selectStar() {
      console.log('this.starName')
      console.log(this.starName)
    },
    computePlanetColor(planetType) {
      switch (planetType) {
        case 'Metal': return '#9f8164'
        case 'Hot': return '#94480e'
        case 'Life': return 'indigo'
        case 'Rock': return '#780109'
        default: return 'grey'
      }
    },
    deleteStar(objectID) {
      console.log(objectID)
      const uri = '/api/general/astro/star/delete'
      axios.post(uri, objectID, config).then(response => {
        this.stars = response.data
      })
    },
    addNewStar() {
      const data = {
        'newStarName': this.newStarName,
        'newStarTemp': this.newStarTemp,
        'newStarClass': this.newStarClass
      }
      const uri = '/api/general/astro/star/new'
      axios.post(uri, data, config).then(response => {
        this.stars = response.data
      })
    },
    addNewPlanet() {
      const data = {
        'starName': this.starName,
        'newPlanetName': this.newPlanetName,
        'newPlanetType': this.newPlanetType
      }
      const uri = '/api/general/astro/star/addPlanet'
      axios.post(uri, data, config).then(response => {
        this.stars = response.data
      })
    }
  },
  computed: {
    planetsAvailable() {
      this.stars.forEach(value => {
      })
    },

    comp_planetButton() {
      return !this.newPlanetName
    },

    comp_starButton() {
      return !this.newStarName
    },

    starsAvailable () {
      let starsAvailable = []
      this.stars.forEach(value => starsAvailable.push(value.objectName))
      return starsAvailable
    }
  }
}
</script>

<style scoped>

</style>