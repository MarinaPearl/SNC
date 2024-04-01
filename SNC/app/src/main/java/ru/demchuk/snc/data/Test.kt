package ru.demchuk.snc.data

data class Test (
    val input_id:Int,
    val input_cost : Int,
    val input_name : String,
)

data class TestList (
    val list : List<Test>
)