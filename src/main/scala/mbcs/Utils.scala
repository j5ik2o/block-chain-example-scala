package mbcs

object Utils {

  def using[A: Disposer, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      implicitly[Disposer[A]].dispose(resource)
    }

  trait Disposer[-A] {

    def dispose(resource: A): Unit

  }

  object Disposer {
    import java.io._

    // InputStreamのサブ型であればどの実装でもストリームを閉じることができる
    implicit val inputStreamDisposer = new Disposer[InputStream] {
      override def dispose(resource: InputStream): Unit =
        resource.close()
    }

    // OutputStreamのサブ型にも対応した場合は、以下を参考する。
     implicit val outputStreamDisposer = new Disposer[OutputStream] {
      override def dispose(resource: OutputStream): Unit =
        resource.close()
     }
  }

}
