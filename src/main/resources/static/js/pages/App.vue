<template>
  <v-app>
    <v-content>
      <v-app-bar color="deep-purple accent-4" dense dark>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
        <v-toolbar-title>Aposfera</v-toolbar-title>



        <v-spacer></v-spacer>
        <!--<v-btn icon>
          <v-icon>mdi-heart</v-icon>
        </v-btn>-->
        <v-menu left bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon v-bind="attrs" v-on="on">
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="n in 5" :key="n" @click="() => {}">
              <v-list-item-title>Option {{ n }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-app-bar>


      <!--TO PAGE ELEMENT-->
      <!--SYSTEMS STAR MAP-->
      <v-container fluid class="system-map-container" >

        <v-row>
          <v-col>
            <!--DialogButton-->
            <astro-menu-page></astro-menu-page>
            <ship-menu-page></ship-menu-page>



          </v-col>
        </v-row>


        <v-row v-for="star in stars" :key="star.objectID">
          <v-col >
            <!--STAR CARD-->
            <v-card >
              <v-card-actions v-if="deleteMode">
                <v-btn icon @click="deleteStar(star.objectID)">
                  <v-icon>mdi-delete</v-icon>
                </v-btn>
              </v-card-actions>
              <v-row>
                <v-col cols="8">
                  <v-card-title>
                    <v-icon>mdi-star-four-points-outline</v-icon>
                    <span>&nbsp;{{star.objectName}}</span>
                  </v-card-title>
                </v-col>
                <v-col style="padding-top: 17px">
                  <v-card-text>
                    {{star.spectralClass}}
                  </v-card-text>
                </v-col>
              </v-row>
              <v-card-subtitle>
                <span class="font-weight-medium">{{star.planets.length}}</span>&nbsp;
                <!---->
                <span v-if="star.planets.length === 1">Planet</span>
                <span v-else>Planets</span>
              </v-card-subtitle>
              <!--PLANETS OF STAR-->
              <v-row>
                <v-col cols="3">
                  <v-card-actions>
                    <v-card outlined>
                      <v-card-actions>
                        <v-btn
                            color="#feb92e"
                            fab
                            x-large
                            dark
                            width="400"
                            height="400"
                        >
                          <img
                              src="http://pngimg.com/uploads/sun/sun_PNG13424.png"
                              width="490"
                              height="490">
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-card-actions>
                </v-col>
                <v-col>
                  <v-card-actions>
                    <div>
                      <v-row >
                        <!--PLANET CARD-->
                        <v-card outlined v-for="(planet, i) in star.planets" :key="planet.objectID" style="margin: auto;" class="mb-1 ml-2">
                          <v-col>
                            <span class="font-weight-thin">{{i + 1}}</span>
                            <v-chip class="ma-2" :color="computePlanetColor(planet.planetType)" :text-color="computePlanetColor(planet.planetType)" outlined>
                              <v-avatar left>
                                <v-icon>mdi-earth</v-icon>
                              </v-avatar>
                              <span class="font-weight-medium">{{planet.objectName}}&nbsp;</span>
                              <span class="font-weight-light">{{planet.planetType}}</span>
                            </v-chip>
                          </v-col>
                          <!--PLANET CANVAS-->
                          <v-card-actions>
                            <v-btn
                                color="#c1440e"
                                fab
                                x-large
                                dark
                                width="150"
                                height="150"
                            >
                              <img
                                  src="https://pngimg.com/uploads/mars_planet/mars_planet_PNG28.png"
                                  width="150"
                                  height="150">
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-row>
                    </div>
                  </v-card-actions>
                </v-col>
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import axios from 'axios'
import AstroMenuPage from "./AstroMenuPage.vue";
import ShipMenuPage from "./ShipMenuPage.vue";

const config = {
  headers: {
    'Content-Type': 'application/json'
  }
}

export default {
  components: {
    AstroMenuPage, ShipMenuPage
  },
  data() {
    return {
      stars: [],
      deleteMode: false,
    }
  },
  created() {
    const uri = '/api/general/astro/star'
    axios.get(uri).then(response => {
      this.stars = response.data
      console.log(this.stars)
    })
  },
  methods: {
    addShip() {
      console.log('Add ship')
      const uri = '/api/rest/ship/add'
      axios.post(uri).then(response => {
        console.log('response', response)
      })
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

  },
  computed: {
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
.system-map-container {
  min-height: 1000px;
  border: 2px solid darkblue;
}
</style>