fun main() {
    val grievanceController: RuntimeGrievanceDao = RuntimeGrievanceDao()
    grievanceController.registerAndDispatch("smth")
}
