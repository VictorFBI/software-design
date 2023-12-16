import kotlin.random.Random


interface GrievanceHandler {
    fun handle(grievanceEntity: GrievanceEntity, daysFromPurchase: Int)
}

class RuntimeGrievanceHandler : GrievanceHandler {
    override fun handle(grievanceEntity: GrievanceEntity, daysFromPurchase: Int) {
        if (daysFromPurchase <= 3) {
            println("Grievance is handled")
        } else {
            println("Grievance is rejected")
        }
    }
}