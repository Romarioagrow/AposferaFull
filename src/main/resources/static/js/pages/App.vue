`<template>
    <v-app>
        <v-content>
            <v-container>
                <v-row>
                    <v-col v-for="star in stars" :key="star.objectID">
                        <v-card>
                            <v-card-text>
                                {{star.objectName}}
                                <v-divider/>
                                {{star.spectralClass}}
                                <v-divider/>
                                {{star.planets}}
                            </v-card-text>
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
                        <v-btn color="primary" block @click="addNewStar()">Add New Star</v-btn>
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
                        <v-btn color="success" block @click="addNewPlanet()">Add New Planet</v-btn>
                    </v-card-actions>
                </v-card>
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
                //console.log(this.objects)
            })
        },
        methods: {
            addNewStar() {
                const data = {
                    'newStarName': this.newStarName,
                    'newStarTemp': this.newStarTemp,
                    'newStarClass': this.newStarClass
                }

                const uri = '/api/general/astro/star/new'
                axios.post(uri, data, config).then(response => {
                    this.stars = response.data
                    //console.log(this.objects)
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

                    //console.log(this.objects)
                })

            }
        },
        computed: {
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