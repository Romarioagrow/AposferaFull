`<template>
    <v-app>
        <v-content>
            <v-container>
                <v-row>
                    <v-col v-for="star in stars" :key="star.objectID">

                        <!--STAR CARD-->
                        <v-card max-width="250">
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
                                Planets
                            </v-card-subtitle>

                            <v-card-actions v-for="planet in star.planets" :key="planet.objectID">
                                <v-chip class="ma-2" :color="computePlanetColor(planet.planetType)" :text-color="computePlanetColor(planet.planetType)" outlined>
                                    <v-avatar left>
                                        <v-icon>mdi-earth</v-icon>
                                    </v-avatar>
                                    <span class="font-weight-medium">{{planet.objectName}}&nbsp;</span>
                                    <span class="font-weight-light">{{planet.planetType}}</span>
                                </v-chip>
                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>

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
        </v-content>
    </v-app>
</template>

<script>
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
                starName: ''
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

<style scoped></style>