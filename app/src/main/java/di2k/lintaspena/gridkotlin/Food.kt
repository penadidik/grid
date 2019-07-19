package di2k.lintaspena.gridkotlin
//Created by 디딬 Didik M. Hadiningrat on 19 July 201
class Food {
    var name: String? = null
    var description: String? = null
    var image: Int? = null

    constructor(name: String, description: String,  image: Int){
        this.name = name
        this.description = description
        this.image = image
    }
}