package edu.neu.coe.csye7200.asstfc

import scala.util.Try

/**
 * This object extends scala.Function to include more methods that apply to functions.
 *
 * Created by scalaprof on 10/2/16.
 */
object Function {

  /**
   * The map2 function. You already know this one!
   *
   * @param t1y parameter 1 wrapped in Try
   * @param t2y parameter 2 wrapped in Try
   * @param f   function that takes two parameters of types T1 and T2 and returns a value of R
   * @tparam T1 the type of parameter 1
   * @tparam T2 the type of parameter 2
   * @tparam R  the type of the result of function f
   * @return a value of R, wrapped in Try
   */
  def map2[T1, T2, R](t1y: Try[T1], t2y: Try[T2])(f: (T1, T2) => R): Try[R] =
  // TO BE IMPLEMENTED
    t1y.flatMap(p1 => t2y.map(p2 => f(p1,p2)))

  /**
   * Lift function to transform a function f of type T=>R into a function of type Try[T]=>Try[R]
   *
   * @param f the function we start with, of type T=>R
   * @tparam T the type of the parameter to f
   * @tparam R the type of the result of f
   * @return a function of type Try[T]=>Try[R]
   */
  // You know this one
  def lift[T, R](f: T => R): Try[T] => Try[R] = (t: Try[T]) => t.map(f)
  // TO BE IMPLEMENTED 



  /**
   * Lift function to transform a function f of type (T1,T2)=>R into a function of type (Try[T1],Try[T2])=>Try[R]
   *
   * @param f the function we start with, of type (T1,T2)=>R
   * @tparam T1 the type of the first parameter to f
   * @tparam T2 the type of the second parameter to f
   * @tparam R  the type of the result of f
   * @return a function of type (Try[T1],Try[T2])=>Try[R]
   */
  // Think Simple, Elegant, Obvious
  def lift2[T1, T2, R](f: (T1, T2) => R): (Try[T1], Try[T2]) => Try[R] =
    (t1y: Try[T1], t2y: Try[T2]) => t1y.flatMap(p1 => t2y.map(p2 => f(p1, p2)))
  // TO BE IMPLEMENTED 



  /**
   * Lift function to transform a function f of type (T1,T2,T3)=>R into a function of type (Try[T1],Try[T2],Try[T3])=>Try[R]
   *
   * @param f the function we start with, of type (T1,T2,T3)=>R
   * @tparam T1 the type of the first parameter to f
   * @tparam T2 the type of the second parameter to f
   * @tparam T3 the type of the third parameter to f
   * @tparam R  the type of the result of f
   * @return a function of type (Try[T1],Try[T2],Try[T3])=>Try[R]
   */
  // If you can do lift2, you can do lift3
  def lift3[T1, T2, T3, R](f: (T1, T2, T3) => R): (Try[T1], Try[T2], Try[T3]) => Try[R] =
  // TO BE IMPLEMENTED
    (t1y: Try[T1], t2y: Try[T2], t3y: Try[T3]) => t1y.flatMap(p1 => t2y.flatMap(p2 => t3y.map(p3 => f(p1,p2,p3))))


  /**
   * The map3 function. Much like map2
   *
   * @param t1y parameter 1 wrapped in Try
   * @param t2y parameter 2 wrapped in Try
   * @param t3y parameter 3 wrapped in Try
   * @param f   function that takes three parameters of types T1, T2 and T3 and returns a value of R
   * @tparam T1 the type of parameter 1
   * @tparam T2 the type of parameter 2
   * @tparam T3 the type of parameter 3
   * @tparam R  the type of the result of function f
   * @return a value of R, wrapped in Try
   */
  def map3[T1, T2, T3, R](t1y: Try[T1], t2y: Try[T2], t3y: Try[T3])(f: (T1, T2, T3) => R): Try[R] =
  // TO BE IMPLEMENTED
    t1y.flatMap(p1 => t2y.flatMap(p2 => t3y.map(p3 => f(p1,p2,p3))))

  /**
   * Lift function to transform a function f of type (T1,T2,T3,T4,T5,T6,T7)=>R into a function of type (Try[T1],Try[T2],Try[T3],Try[T4],Try[T5],Try[T6],Try[T7])=>Try[R]
   *
   * @param f the function we start with, of type (T1,T2,T3,T4,T5,T6,T7)=>R
   * @tparam T1 the type of the first parameter to f
   * @tparam T2 the type of the second parameter to f
   * @tparam T3 the type of the third parameter to f
   * @tparam T4 the type of the fourth parameter to f
   * @tparam T5 the type of the fifth parameter to f
   * @tparam T6 the type of the sixth parameter to f
   * @tparam T7 the type of the seventh parameter to f
   * @tparam R  the type of the result of f
   * @return a function of type (Try[T1],Try[T2],Try[T3],Try[T4],Try[T5],Try[T6],Try[T7])=>Try[R]
   */
  // If you can do lift3, you can do lift7
  def lift7[T1, T2, T3, T4, T5, T6, T7, R](f: (T1, T2, T3, T4, T5, T6, T7) => R):
  (Try[T1], Try[T2], Try[T3], Try[T4], Try[T5], Try[T6], Try[T7]) => Try[R] =
  // TO BE IMPLEMENTED
    (t1y: Try[T1], t2y: Try[T2], t3y: Try[T3], t4y: Try[T4], t5y: Try[T5], t6y: Try[T6], t7y: Try[T7]) =>
    t1y.flatMap(p1 => t2y.flatMap(p2 => t3y.flatMap(p3 => t4y.flatMap(p4 => t5y.flatMap(p5 => t6y.flatMap(p6 => t7y.map(p7 => f(p1,p2,p3,p4,p5,p6,p7))))))))

  /**
   * You get the idea...
   */
  def map7[T1, T2, T3, T4, T5, T6, T7, R](t1y: Try[T1], t2y: Try[T2], t3y: Try[T3], t4y: Try[T4], t5y: Try[T5], t6y: Try[T6], t7y: Try[T7])
                                         (f: (T1, T2, T3, T4, T5, T6, T7) => R): Try[R] =
  // TO BE IMPLEMENTED 
    t1y.flatMap(p1 => t2y.flatMap(p2 => t3y.flatMap(p3 => t4y.flatMap(p4 => t5y.flatMap(p5 => t6y.flatMap(p6 => t7y.map(p7 => f(p1,p2,p3,p4,p5,p6,p7))))))))

  /**
   * This method inverts the order of the first two parameters of a two-(or more-)parameter curried function.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam R  the result type
   * @return a curried function which takes the second parameter first
   */
  // Hint: think about writing an anonymous function that takes a t2, then a t1 and returns the appropriate result
  // NOTE: you won't be able to use the "_" character here because the compiler infers an ordering that you don't want
  def invert2[T1, T2, R](f: T1 => T2 => R): T2 => T1 => R =
  // TO BE IMPLEMENTED
    (t2: T2) => (t1: T1) => f(t1)(t2)

  /**
   * This method inverts the order of the first three parameters of a three-(or more-)parameter curried function.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam T3 the type of the third parameter
   * @tparam R  the result type
   * @return a curried function which takes the third parameter first, then the second, etc.
   */
  // If you can do invert2, you can do this one too
  def invert3[T1, T2, T3, R](f: T1 => T2 => T3 => R): T3 => T2 => T1 => R =
  // TO BE IMPLEMENTED
    (p3: T3) => (p2: T2) => (p1: T1) => f(p1)(p2)(p3)

  /**
   * This method inverts the order of the first four parameters of a four-(or more-)parameter curried function.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam T3 the type of the third parameter
   * @tparam T4 the type of the fourth parameter
   * @tparam R  the result type
   * @return a curried function which takes the fourth parameter first, then the third, etc.
   */
  // If you can do invert3, you can do this one too
  def invert4[T1, T2, T3, T4, R](f: T1 => T2 => T3 => T4 => R): T4 => T3 => T2 => T1 => R =
  // TO BE IMPLEMENTED
    (p4: T4) => (p3: T3) => (p2: T2) => (p1: T1) => f(p1)(p2)(p3)(p4)

  /**
   * This method uncurries the first two parameters of a three- (or more-)
   * parameter curried function.
   * The result is a (curried) function whose first parameter is a tuple of the first two parameters of f;
   * whose second parameter is the third parameter, etc.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam T3 the type of the third parameter
   * @tparam R  the result type of function f
   * @return a (curried) function of type (T1,T2)=>T4=>R
   */
  // This one is a bit harder. But again, think in terms of an anonymous function that is what you want to return
  def uncurried2[T1, T2, T3, R](f: T1 => T2 => T3 => R): (T1, T2) => T3 => R =
  // TO BE IMPLEMENTED
    (p1: T1, p2: T2) => (p3: T3) => f(p1)(p2)(p3)

  /**
   * This method uncurries the first three parameters of a four- (or more-)
   * parameter curried function.
   * The result is a (curried) function whose first parameter is a tuple of the first three parameters of f;
   * whose second parameter is the third parameter, etc.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam T3 the type of the third parameter
   * @tparam T4 the type of the fourth parameter
   * @tparam R  the result type of function f
   * @return a (curried) function of type (T1,T2,T3)=>T4=>R
   */
  // If you can do uncurried2, then you can do this one
  def uncurried3[T1, T2, T3, T4, R](f: T1 => T2 => T3 => T4 => R): (T1, T2, T3) => T4 => R =
  // TO BE IMPLEMENTED
    (p1: T1, p2: T2, p3: T3) => (p4: T4) => f(p1)(p2)(p3)(p4)

  /**
   * This method uncurries the first three parameters of a four- (or more-)
   * parameter curried function.
   * The result is a (curried) function whose first parameter is a tuple of the first seven parameters of f;
   * whose second parameter is the third parameter, etc.
   *
   * @param f the function
   * @tparam T1 the type of the first parameter
   * @tparam T2 the type of the second parameter
   * @tparam T3 the type of the third parameter
   * @tparam T4 the type of the fourth parameter
   * @tparam R  the result type of function f
   * @return a (curried) function of type (T1,T2,T3)=>T4=>R
   */
  // If you can do uncurried3, then you can do this one
  def uncurried7[T1, T2, T3, T4, T5, T6, T7, T8, R](f: T1 => T2 => T3 => T4 => T5 => T6 => T7 => T8 => R): (T1, T2, T3, T4, T5, T6, T7) => T8 => R =
  // TO BE IMPLEMENTED
    (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5, p6: T6, p7: T7) => (p8: T8) => f(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)


  def sequence[X](xys: Seq[Try[X]]): Try[Seq[X]] = xys.foldLeft(Try(Seq[X]())) {
    (xsy, xy) => for (xs <- xsy; x <- xy) yield xs :+ x
  }

  //  val m = new immutable.HashMap[String, Int]
  //  def put[K >: String,V](k: K, v: V): Map[K, V] = m.updated(k, v)
}