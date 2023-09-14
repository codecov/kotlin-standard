# Kotlin-Standard

[![Workflow for Kotlin Standard Action](https://github.com/codecov/kotlin-standard/actions/workflows/kotlin-standard.yml/badge.svg)](https://github.com/codecov/kotlin-standard/actions/workflows/kotlin-standard.yml) [![codecov](https://codecov.io/gh/codecov/kotlin-Standard/branch/master/graph/badge.svg)](https://codecov.io/gh/codecov/kotlin-Standard)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fcodecov%2Fkotlin-standard.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fcodecov%2Fkotlin-standard?ref=badge_shield)

### Last Updated: 09/14/23 00:12:53

## What is this?

This is a **Kotlin/Gradle** application, with basic unit tests, for which coverage is uploaded to Codecov on a daily basis. It can also serve as an example for how to integrate Codecov into your Kotlin project. If the build is passing for this project, then Codecov's Kotlin report processing is functional and correct on codecov.io.

## Configuration

This project is written in `Kotlin 1.3` and is built using `Gradle 6.2.2`. Unit test are written using the `Spek` framework and coverage reports are generated using `Jacoco` plugin.

## Usage

### The Docker Way

Run unit tests inside a Docker container
```bash
docker-compose up
```

### The Local Way

Build the project
```
./gradlew build
```

Run tests
```
./gradlew test
```

## Reporting Issues

If you've discovered an issue with this repository or with Kotlin processing in general, it is recommended to email support@codecov.io rather than post an issue here. This repository will not be checked regularly for open issues.

## Contributing

Contributions are welcome! If you'd like to contribute to this repository, feel free to open a pull request or flag an issue. If you would like to contribute a new lanaguage standard, [you can get more information here](https://github.com/codecov/standards-scripts/blob/master/README.md#contributing). 


## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fcodecov%2Fkotlin-standard.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fcodecov%2Fkotlin-standard?ref=badge_large)