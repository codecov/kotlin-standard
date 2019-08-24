package codecov

fun uncovered_if(a: Boolean = true): Boolean {
	if (a) 
		return false
	else
		return true
}

fun fully_covered(): Boolean {
	return true
}

fun uncovered(): Boolean {
	return true
}

