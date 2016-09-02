var ans;

/**
 * @param {string} input
 * @return {number}
 */
var lengthLongestPath = function(input) {
  ans = 0;
  dfs(input, 0, 0);

  return ans === 0? ans : ans -1;
};

function dfs(str, depth, len) {
  // str = str.trim();

  var pattern = "\\n";
  // "\n\t(?!\t)"
  for (var i = 0; i < depth; i++)
    pattern += "\\t";

  if (str.indexOf(pattern) === -1) {
    // dir[depth].push(str);
    // 如果是文件
    if (str.indexOf('.') !== -1)
      ans = Math.max(ans, len + 1 + str.length);
    return;
  }

  // 分割
  pattern += "[^\\t]"

  var arr = str.split(new RegExp(pattern));

  if (arr.length === 1) {
    dfs(str, depth + 1, len)
  } else {
    var dir = arr[0];

    for (var i = 1; i < arr.length; i++) {
      dfs(arr[i], depth + 1, len + 1 + dir.length);
    }
  }
}