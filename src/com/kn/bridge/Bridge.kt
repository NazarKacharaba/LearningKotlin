package com.kn.bridge

interface WallCreator {
    fun buildWallWithDoor()
    fun buildWall()
    fun buildWallWithWindow()
}

interface BuildingCompany {
    fun buildFoundation()
    fun buildRoof()
    fun buildRoom()
    fun setWallCreator(wallCreator: WallCreator)
}

class KoAndKoCompany() : BuildingCompany {
    private var wallCreator: WallCreator? = null

    override fun setWallCreator(wallCreator: WallCreator) {
        this.wallCreator = wallCreator
    }

    override fun buildFoundation() {
        println("Build foundation")
    }

    override fun buildRoof() {
        println("Build roof")
    }

    override fun buildRoom() {
        wallCreator?.buildWallWithDoor();
        wallCreator?.buildWall();
        wallCreator?.buildWallWithWindow();
        wallCreator?.buildWall();
    }
}

class BrickWallCreator : WallCreator {
    override fun buildWallWithDoor() = println("Brick wall with door is built")
    override fun buildWall() = println("Brick wall is built")
    override fun buildWallWithWindow() = println("Brick wall with window is built")
}

class ConcreteSlabWallCreator : WallCreator {
    override fun buildWallWithDoor() = println("Concrete wall with door is built")
    override fun buildWall() = println("Concrete wall is built")
    override fun buildWallWithWindow() = println("Concrete wall with window is built")
}


fun main(args: Array<String>) {
    val company = KoAndKoCompany()

    company.setWallCreator(BrickWallCreator())
    company.buildFoundation()
    company.buildRoom()
    company.buildRoof()

    // build another building
    // switch to another wall creator type
    company.setWallCreator(ConcreteSlabWallCreator())
    company.buildFoundation()
    company.buildRoom()
    company.buildRoof()

}