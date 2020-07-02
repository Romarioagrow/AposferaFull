`<template>
    <v-app>

        <!--<v-content>




        </v-content>-->


        <v-content>



            <!--SYSTEMS STAR MAP-->
            <v-container fluid class="system-map-container">

                <!--<v-row>
                    <div>
                        <v-stage ref="stage" :config="stageSize">
                            <v-layer>
                                <v-text :config="{text: 'Some text on canvas', fontSize: 15}"/>
                                <v-circle :config="{
                                      x: 200,
                                      y: 100,
                                      radius: 50,
                                      fill: 'blue'
                                    }"
                                />
                            </v-layer>
                            <v-layer ref="dragLayer"></v-layer>
                        </v-stage>
                    </div>
                </v-row>-->


                <!--SYSTEM STAR FOR-->
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
                                                        <!--<div>
                                                            <v-stage ref="stage" :config="stageSize">
                                                                <v-layer>
                                                                    <v-text :config="{text: 'Some text on canvas', fontSize: 15}"/>
                                                                    <v-circle :config=planetCanvasParam >
                                                                        <v-img src="https://w0.pngwave.com/png/174/688/earth-m-02j71-astronomical-object-planet-space-planet-png-clip-art.png"></v-img>
                                                                    </v-circle>
                                                                </v-layer>
                                                                <v-layer ref="dragLayer"></v-layer>
                                                            </v-stage>
                                                        </div>-->
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





            <!--STAR SYSTEMS MENU-->
            <v-container>
                <v-card>
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
            </v-container>




            <!--STAR SYSTEMS MENU-->
            <v-container>
                <v-card>
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
                <v-row>
                    <v-col>
                        <v-btn color="red" :outlined="!deleteMode" @click.stop="deleteMode = !deleteMode">Delete Mode</v-btn>
                    </v-col>
                </v-row>
            </v-container>



            <!--MOON TO PLANET-->

            <v-container>
                <v-card>
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
                <v-row>
                    <v-col>
                        <v-btn color="red" :outlined="!deleteMode" @click.stop="deleteMode = !deleteMode">Delete Mode</v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
    /*PLANET CANVAS PARAMS*/
    const width = 200;
    const height = 200;
    let vm = {};



    const config = {
        headers: {
            'Content-Type': 'application/json'
        }
    }




    import axios from 'axios'
    export default {
        data() {
            return {
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
        created() {
            const uri = '/api/general/astro/star'
            axios.get(uri).then(response => {

                this.stars = response.data
                console.log(this.stars)
                //console.log(this.objects)
            })
        },


        methods: {

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
                // @change="selectStar()"

                this.stars.forEach(value => {
                    //this.starsAvailable.push(value.objectName)

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
                //this.stars = (star) => star.objectName
                this.stars.forEach(value => starsAvailable.push(value.objectName))
                return starsAvailable
            }
        }
    }
</script>

<style scoped>

    .system-map-container {
        /*margin-left: 5%;
        margin-right: 5%;
        margin-top: 5%;*/
    }


</style>