require 'differ'


class DifferUtility

  def get_diff(string1, string2)
    Differ.format = :color
    puts Differ.diff_by_word(string1, string2)
  end

end
