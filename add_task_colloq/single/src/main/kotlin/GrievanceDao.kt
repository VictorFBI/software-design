interface GrievanceDao {
    fun registerAndDispatch(text: String)
    fun consider(id: Int)
}

class RuntimeGrievanceDao : GrievanceDao {
    private val _grievances = mutableListOf<GrievanceEntity>()
    private var _counter = 0
    private val _grievanceHandler: RuntimeGrievanceHandler = RuntimeGrievanceHandler()

    override fun registerAndDispatch(text: String) {
        _grievances.add(GrievanceEntity(_counter, text))
        _grievanceHandler.handle(_grievances[_counter], 2)
        _counter++
    }

    override fun consider(id: Int) {
        TODO()
    }

}