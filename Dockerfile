FROM eclipse-temurin:17-jdk

WORKDIR /app

# 必要なツールのインストール
RUN apt-get update && apt-get install -y \
    unzip zip git curl bash vim wget \
    && rm -rf /var/lib/apt/lists/*

# 1. 全ファイルをコピー（これで wrapper も入る）
COPY . .

# 2. 権限付与
RUN chmod +x gradlew

# 3. 依存関係のダウンロード（ここで 8.14.3 がダウンロード・保存される）
RUN ./gradlew --no-daemon dependencies

EXPOSE 8080